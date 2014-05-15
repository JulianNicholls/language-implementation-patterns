#! /usr/bin/env ruby -I. -I..

require 'memoise_parser'

lexer = ListLexer.new( ARGV[0] )
bp    = MemoiseParser.new( lexer )

bp.stat
 