require 'token'

class AST
  # Can be initialised with a token, token type or nothing
  def initialize( token = nil )
    if token.nil? || token.respond_to?( :type )
      @token = token
    else
      @token = Token.new( token )
    end

    @children = []
  end

  def type
    token.type
  end

  def add_child( t )
    @children << t
  end

  def is_nil?
    @token.nil?
  end

  def to_s
    @token.nil? ? 'nil' : @token.to_s
  end

  def to_tree
    return to_s if @children.empty?

    ret = is_nil? ? '' : "(#{to_s} "
    ret += @children.map( &:to_tree ).join ' '

    ret + (is_nil? ? '' : ')')
  end
end
