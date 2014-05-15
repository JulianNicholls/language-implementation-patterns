require 'heteroast'

class ExprNode < HeteroAST
end

class AddNode < ExprNode
  def initialize( left, add_token, right )
    super( add_token )
    @left, @right = left, right
  end

  def to_tree
    "(#{to_s} #{@left.to_tree} #{@right.to_tree})"
  end
end

class IntNode < ExprNode
end

class ListNode < ExprNode
  def initialize( elements )
    @elements = elements
  end
  
  def to_tree
    return to_s if @elements.nil? || @elements.empty?
    
    @elements.map( &:to_tree ).join ' '
  end
end

class VectorNode < ExprNode
  def initialize( token, elements )
    super( token )
    @elements = elements
  end
end
