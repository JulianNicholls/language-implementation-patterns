class Token
  INVALID = 0
  PLUS    = 1
  MINUS   = 2
  INT     = 3
  
  attr_reader :type, :text
  
  def initialize( type, text = '' )
    @type, @text = type, text
  end
  
  def to_s
    text
  end
  
  alias_method :decode, :to_s
end
