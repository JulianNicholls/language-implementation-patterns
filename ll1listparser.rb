require 'listlexer'
require 'll1parser'

class ListParser < Parser
  def list
    match ListLexer::LBRACK
    elements
    match ListLexer::RBRACK
  end
  
  def elements
    element
    while lookahead.type == ListLexer::COMMA
      match ListLexer::COMMA
      element
    end
  end
  
  def element
    if lookahead.type == ListLexer::NAME
      match ListLexer::NAME
    elsif lookahead.type == ListLexer::LBRACK
      list
    else
      fail "Expected name or list, found: #{lookahead.decode( ListLexer )}"
    end
  end
end
