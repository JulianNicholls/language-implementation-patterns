include 'token'

class ListLexer < Lexer
  NAME    = 2
  COMMA   = 3
  LBRACK  = 4
  RBRACK  = 5
  
  TOKEN_NAMES = ['Error', '<EOF>', 'NAME', 'COMMA', 'LBRACK', 'RBRACK']
  
  def initialize( input )
    super
  end
  
  def tname( type )
    idx = type >= TOKEN_NAMES.size ? 0 : type
    "#{TOKEN_NAMES[idx]} (#{type})"
  end
  
  def letter?( ch )
    ch.between?( 'A', 'Z' ) || ch.between?( 'a', 'z' ) 
  end
  
  def next_token
    while c != EOF
      case c
      when ' '
      when '\t'
      when '\n'
      when '\r'
        ws
        
      when ','
        consume
        return Token.new( COMMA, c )
        
      when '['
        consume
        return Token.new( LBRACK, c )
        
      when ']'
        consume
        return Token.new( RBRACK, c )
    
      else
        return name if letter? c
        fail "Invalid character '#{c}'"
      end
    end
  end
  
  def name
    ident = ''
    
    loop do
      ident << c
      consume
      break unless letter? c
    end
    
    ident
  end
  
  def ws
    consume while [' ', "\t", "\n", "\r"].include? c
  end
end
