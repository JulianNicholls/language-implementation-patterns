#! /usr/bin/env ruby -I.

require 'll1listparser'

lexer   = ListLexer.new( ARGV[0] )
parser  = ListParser.new( lexer )
parser.list
