#! /usr/bin/env ruby -I.

require 'nodes'

plus  = Token.new( Token::PLUS, '+' )
one   = Token.new( Token::INT, '1' )
two   = Token.new( Token::INT, '2' )

root = AddNode.new( IntNode.new( one ), plus, IntNode.new( two ) )

puts "1+2: #{root.to_tree}"
