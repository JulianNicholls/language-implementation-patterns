#! /usr/bin/env ruby -I.

require 'ast'

plus  = Token.new( Token::PLUS, '+' )
one   = Token.new( Token::INT, '1' )
two   = Token.new( Token::INT, '2' )

root = AST.new plus
root.add_child( AST.new one )
root.add_child( AST.new two )

puts "1+2 tree: #{root.to_tree}"

list = AST.new
list.add_child( AST.new one )
list.add_child( AST.new two )

puts "1 and 2 in list: #{list.to_tree}"
