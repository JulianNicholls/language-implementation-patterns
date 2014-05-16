require 'heteroast'

class VecMathNode < HeteroAST
  def print   # Basic print
    Kernel.print @token.nil? ? '<NIL>' : @token.to_s
  end
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
  def initialize( left, token, right )
    super( token )
    @left, @right = left, right
  end

  def print
    @left.print
    Kernel.print '+'
    @right.print
  end
end

class AssignNode < StatNode
  def initialize( id, token, value )
    super( token )
    @id, @value = id, value
  end

  def print
    @id.print
    Kernel.print '='
    @value.print
    puts
  end
end

class DotProductNode < ExprNode
  def initialize( left, token, right )
    super( token )
    @left, @right = left, right
  end

  def print
    @left.print
    Kernel.print '.'
    @right.print
  end
end

class MultNode < ExprNode
  def initialize( left, token, right )
    super( token )
    @left, @right = left, right
  end

  def print
    @left.print
    Kernel.print '*'
    @right.print
  end
end

class PrintNode < StatNode
  def initialize( token, value )
    super( token )
    @value = value
  end

  def print
    Kernel.print 'print '
    @value.print
    puts
  end
end

class StatListNode < VecMathNode
  def initialize( elements )
    super( Token.new Token::STAT_LIST )
    @elements = elements
  end

  def print
    @elements.each { |e| e.print }
  end
end

class VectorNode < ExprNode
  def initialize( token, elements )
    super( token )
    @elements = elements
  end

  def print
    Kernel.print '['
    @elements.each_with_index do |elem, idx|
      Kernel.print ', ' if idx > 0
      elem.print
    end
    
    Kernel.print ']'
  end
end
