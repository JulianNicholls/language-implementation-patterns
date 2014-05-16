#! /usr/bin/env ruby -I.

require 'nodes'

def i( value )
  IntNode.new( Token.new( Token::INT, value ) )
end

stats = []

a = AddNode.new( i(3), Token.new( Token::PLUS ), i(4) )
x = VarNode.new( Token.new( Token::ID, 'x' ) )

assign = AssignNode.new( x, Token.new( Token::ASSIGN, '=' ), a )
stats << assign

mult = Token.new( Token::MULT, '*' )

elements = []
elements << ExprNode.new( i(2) )
elements << ExprNode.new( i(3) )
elements << ExprNode.new( i(4) )

v = VectorNode.new( Token.new( Token::VEC ), elements )

xref = VarNode.new( Token.new( Token::ID, 'x' ) )
pv = MultNode.new( xref, mult, v )
p = PrintNode.new( Token.new( Token::PRINT, 'print' ), pv )
stats << p

statlist = StatListNode.new( stats )
statlist.print
