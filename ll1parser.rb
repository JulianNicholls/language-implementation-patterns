require 'lexer'

class Parser
  attr_reader :lookahead
  
  def initialize( input )
    @input      = input
    consume
  end
  
  def match( expected )
    if lookahead.type == expected
      consume
    else
      fail "Expected #{@input.tname expected}, found: #{lookahead}"
    end
  end
  
  def consume
    @lookahead = @input.next_token
  end
end
