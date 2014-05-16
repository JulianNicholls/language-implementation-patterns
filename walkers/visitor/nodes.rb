require 'heteroast'

# I have retained the type hierarchy from the book, but you can see it's
# pretty redundant here

class VecMathNode < HeteroAST
end

class ExprNode < VecMathNode
end

class StatNode < VecMathNode
end

class VarNode < ExprNode
end

class IntNode < ExprNode
end

class AddNode < ExprNode
  attr_reader :left, :right

  def initialize( left, token, right )
    super( token )
    @left, @right = left, right
  end
end

class AssignNode < StatNode
  attr_reader :id, :value

  def initialize( id, token, value )
    super( token )
    @id, @value = id, value
  end
end

class DotProductNode < ExprNode
  attr_reader :left, :right

  def initialize( left, token, right )
    super( token )
    @left, @right = left, right
  end
end

class MultNode < ExprNode
  attr_reader :left, :right

  def initialize( left, token, right )
    super( token )
    @left, @right = left, right
  end
end

class PrintNode < StatNode
  attr_reader :value

  def initialize( token, value )
    super( token )
    @value = value
  end
end

class StatListNode < VecMathNode
  attr_reader :elements

  def initialize( elements )
    super( Token.new Token::STAT_LIST )
    @elements = elements
  end
end

class VectorNode < ExprNode
  attr_reader :elements
  
  def initialize( token, elements )
    super( token )
    @elements = elements
  end
end
