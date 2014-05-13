#! /usr/bin/env ruby -I.

require 'llklistparser'

# Parse slightly more complicated lists:
#   [a, b, c]
#   [a, [b, c], d]
#   [a=b, c = d, [d, f], q]

lexer   = ListLexer.new( ARGV[0] )
parser  = ListParser.new( lexer, 2 )  # Only needs to look ahead one
parser.list
