class Token
  attr_reader :type, :text
  
  def initialize( type, text )
    @type, @text = type, text
  end
  
  def to_s( lexer = nil )
    tname = lexer.nil? ? type : lexer.tname( type )
    
    "<'#{text}', #{tname}>"
  end
end
