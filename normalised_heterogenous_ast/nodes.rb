require 'ast'

class ExprNode < AST
  INVALID = 0
  INTEGER = 1
  VECTOR  = 2

  attr_reader :eval_type

  def to_s
    unless eval_type.nil? || eval_type == INVALID
      return super + '<type=' +
      (eval_type == INTEGER ? 'tINTEGER' : 'tVECTOR') + '>'
    end

    super
  end
end

class AddNode < ExprNode
  def initialize( left, add_token, right )
    super( add_token )
    add_child left
    add_child right
  end
end

class IntNode < ExprNode
  def initialize( token )
    super
    @eval_type = INTEGER
  end
end

class VectorNode < ExprNode
  def initialize( token, elements )
    super( token )
    @eval_type = VECTOR
    @elements.each { |e| add_child( e ) }
  end
end
