#! /usr/bin/env ruby -I.

require 'llklistparser'

lexer   = ListLexer.new( ARGV[0] )
parser  = ListParser.new( lexer, 2 )  # Only needs to look ahead one
parser.list
