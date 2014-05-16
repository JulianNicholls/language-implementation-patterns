#! /usr/bin/env ruby -I.

require 'visitor'

def i( value )
  IntNode.new( Token.new( Token::INT, value ) )
end

stats = []

a = AddNode.new( i(3), Token.new( Token::PLUS ), i(4) )
x = VarNode.new( Token.new( Token::ID, 'x' ) )

assign = AssignNode.new( x, Token.new( Token::ASSIGN, '=' ), a )
stats << assign

mult = Token.new( Token::MULT, '*' )
dp   = Token.new( Token::DOT, '.' )

v = VectorNode.new( Token.new( Token::VEC ), [i(2), i(3), i(4)] )

xref = VarNode.new( Token.new( Token::ID, 'x' ) )
pv = MultNode.new( xref, mult, v )
p = PrintNode.new( Token.new( Token::PRINT, 'print' ), pv )
stats << p

# Added a dot product because it's unused in the book

vec1 = VectorNode.new( Token.new( Token::VEC ), [i(2), i(3)] )
vec2 = VectorNode.new( Token.new( Token::VEC ), [i(7), i(8)] )
dot  = DotProductNode.new( vec1, dp, vec2 )
p2   = PrintNode.new( Token.new( Token::PRINT, 'print' ), dot )
stats << p2

statlist = StatListNode.new( stats )

visitor = IndependentPrintVisitor.new
visitor.print_node( statlist )