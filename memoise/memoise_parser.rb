require 'parser'

class MemoiseParser < Parser
  def initialize( input )
    super
    clear_memos
  end

  def clear_memos
    @list_memo = {}
  end

  # stat: list EOF | assign EOF
  def stat
    if speculate_stat_list
      list
      match( Lexer::EOF_TYPE )
      puts "Matched list."
    elsif speculate_stat_assign
      assign
      match( Lexer::EOF_TYPE )
      puts "Matched assign."
    else
      fail "Expected stat, found #{lat( 1 ).decode( ListLexer )}"
    end
  end

  def speculate_stat_list
    success = true
    mark
    begin
      list
      match( Lexer::EOF_TYPE )
    rescue   => re
#      puts re.message
#      puts re.backtrace.join "\n"
      success = false
    ensure
      release
    end

    success
  end

  def speculate_stat_assign
    success = true
    mark
    begin
      assign
      match( Lexer::EOF_TYPE )
    rescue   => re
#      puts re.message
#      puts re.backtrace.join "\n"
      success = false
    ensure
      release
    end

    success
  end

  def list
    failed = false

    start = index

    return if speculating? && already_parsed?( @list_memo )

    begin
      internal_list
    rescue => re
#      puts re.message
#      puts re.backtrace.join "\n"
      failed = true
      raise
    ensure
      memoise( @list_memo, start, failed )
    end
  end

  def assign
    list
    match ListLexer::EQUALS
    list
  end

  def elements
    element
    while ltype( 1 ) == ListLexer::COMMA
      match ListLexer::COMMA
      element
    end
  end

  def element
    if ltype( 1 ) == ListLexer::NAME && ltype( 2 ) == ListLexer::EQUALS
      match ListLexer::NAME
      match ListLexer::EQUALS
      match ListLexer::NAME
    elsif ltype( 1 ) == ListLexer::NAME
      match ListLexer::NAME
    elsif ltype( 1 ) == ListLexer::LBRACK
      list
    else
      fail "Expected name, assignment, or list, found: #{lat( 1 ).decode( ListLexer )}"
    end
  end

  private

  def internal_list
    puts "parse list rule at token index #{index}"

    match ListLexer::LBRACK
    elements
    match ListLexer::RBRACK
  end

end
