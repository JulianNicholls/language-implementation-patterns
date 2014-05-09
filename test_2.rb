#! /usr/bin/env ruby -I.

require 'listlexer'

lexer = ListLexer.new( ARGV[0] )

t = lexer.next_token

while t.type != Lexer::EOF_TYPE
  puts t.to_s( lexer )
  t = lexer.next_token
end

puts t
