#! /usr/bin/env ruby -I. -I..

require 'backtrackparser'

lexer = ListLexer.new( ARGV[0] )
bp    = BacktrackParser.new( lexer )

bp.stat
 