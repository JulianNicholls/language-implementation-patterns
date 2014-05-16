require 'token'

class HeteroAST
  attr_reader :token

  def initialize( token = nil )
    @token = token
  end

  def to_s
    @token.to_s
  end
end
