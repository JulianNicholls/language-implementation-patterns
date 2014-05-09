require 'token'

class Lexer
  EOF       = -1
  EOF_TYPE  = 1
  
  attr_reader :c
  
  def initialize( input )
    @input  = input
    @p      = 0         # Index into input
    @c      = input[@p]
  end
  
  def consume
    @p += 1
    @c = @p < @input.size ? @input[@p] : EOF
  end
  
  def match( ch )
    if @c == ch
      consume
    else
      fail "Expecting '#{ch}', found '#{c}"
    end
  end
end
