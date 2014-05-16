class Token
  INVALID   = 0
  PLUS      = 1
  MULT      = 2
  DOT       = 3
  INT       = 4
  VEC       = 5
  ID        = 6
  ASSIGN    = 7
  PRINT     = 8
  STAT_LIST = 9
  
  attr_reader :type, :text
  
  def initialize( type, text = '' )
    @type, @text = type, text
  end
  
  def to_s
    text
  end
  
  def print
    fail "Unwrapped Token: #{inspect}"
  end 
end
