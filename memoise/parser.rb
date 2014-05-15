require '../listlexer'

class Parser
  FAILED = -1

  attr_reader :p
  
  alias_method :index, :p
  
  def initialize( input )
    @input      = input
    @markers    = []
    @lookahead  = []
    @p          = 0
    
    sync 1
  end

  def lat( idx )
    sync idx
    @lookahead[@p + idx - 1]
  end

  def ltype( idx )
    lat( idx ).type
  end

  def match( expected )
    if ltype( 1 ) == expected
      consume
    else
      fail "Expected #{ListLexer.tname expected}, found: #{lat( 1 )}"
    end
  end

  def sync( idx )
    if @p + idx - 1 >= @lookahead.size
      n = (@p + idx) - @lookahead.size
      fill n
    end
  end

  def fill( n )
    n.times { @lookahead << @input.next_token }
  end

  def consume
    @p += 1

    if @p == @lookahead.size && !speculating?
      @p = 0
      @lookahead = []
      clear_memos
    end

    sync 1
  end

  def mark
    @markers << @p
    @p
  end

  def release
    last = @markers.pop
    seek last
  end

  def seek( idx )
    @p = idx
  end

  def speculating?
    @markers.size > 0
  end
  
  def already_parsed?( memo )
    return false unless memo.key? index
    
    last = memo[index]
    puts "parsed list before at index #{index}, skip to #{@lookahead[last].text}"
    
    fail "Previous parse failed" if last == FAILED
    seek( last )
    true
  end
  
  def memoise( memo, start, failed )
    stop = failed ? FAILED : index
    memo[start] = stop
  end
end