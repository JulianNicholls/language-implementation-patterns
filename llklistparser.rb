require 'listlexer'
require 'llkparser'

class ListParser < Parser
  def list
    match ListLexer::LBRACK
    elements
    match ListLexer::RBRACK
  end
  
  def elements
    element
    while ltype( 1 ) == ListLexer::COMMA
      match ListLexer::COMMA
      element
    end
  end
  
  def element
    if ltype( 1 ) == ListLexer::NAME && ltype( 2 ) == ListLexer::EQUALS
      match ListLexer::NAME
      match ListLexer::EQUALS
      match ListLexer::NAME
    elsif ltype( 1 ) == ListLexer::NAME
      match ListLexer::NAME      
    elsif ltype( 1 ) == ListLexer::LBRACK
      list
    else
      fail "Expected name, assignment, or list, found: #{lat( 1 ).decode( ListLexer )}"
    end
  end
end
