require 'lexer'

class Parser
  def initialize( input, k )
    @input      = input
    @k          = k
    @p          = 0
    fill_lookahead
  end
  
  def match( expected )
    if ltype( 1 ) == expected
      consume
    else
      fail "Expected #{@input.tname expected}, found: #{lat( 0 )}"
    end
  end
  
  def consume
    @lookahead[@p] = @input.next_token
    @p = (@p + 1) % @k
  end
  
  def lat( idx )
    @lookahead[(@p + idx - 1) % @k]
  end
  
  def ltype( idx )
    lat( idx ).type
  end
  
  private
  
  def fill_lookahead
    @lookahead  = Array( @k )
    @k.times { consume }
  end
end
