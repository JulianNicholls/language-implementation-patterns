require 'lexer'

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
#      puts "P=#{@p}, C='#{c}'"
      case c
      when ' ', "\t", "\n", "\r" then ws
        
      when ','
        consume
        return Token.new( COMMA, ',' )
        
      when '['
        consume
        return Token.new( LBRACK, '[' )
        
      when ']'
        consume
        return Token.new( RBRACK, ']' )
    
      else
        return name if letter? c
        fail "Invalid character '#{c}'"
      end
    end
    
    Token.new( EOF_TYPE, '<eof>' )
  end
  
  def name
    ident = ''
    
    loop do
      ident << c
      consume
      break unless letter? c
    end
    
    Token.new( NAME, ident )
  end
  
  def ws
    consume while [' ', "\t", "\n", "\r"].include? c
  end
end
