require 'token'

class HeteroAST
  # Can be initialised with a token, token type or nothing
  def initialize( token = nil )
    if token.nil? || token.respond_to?( :type )
      @token = token
    else
      @token = Token.new( token )
    end

    @children = []
  end
  
  def to_s
    @token.to_s
  end

  # This base class doesn't hold a list of children, so it just returns itself
  alias_method :to_tree, :to_s
end