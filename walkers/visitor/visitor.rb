require 'nodes'

# Double-dispatch is not going to fly in Ruby, hence we'll just have an
# independent visitor

class IndependentPrintVisitor
  def print_node( node )   # print is a bad name
    case node.token.type
    when Token::ID, Token::INT  then  print node.token.to_s
      
    when Token::PLUS            then  print_add( node )
    when Token::MULT            then  print_mult( node )
    when Token::DOT             then  print_dot( node )
    when Token::VEC             then  print_vec( node )
    when Token::ASSIGN          then  print_assign( node )
    when Token::PRINT           then  print_print( node )
    when Token::STAT_LIST       then  print_stat_list( node )

    else
      puts "Unrecognised so far: #{node.token.inspect}"
    end
  end

  def print_add( node )
    print_node( node.left )
    print ' + '
    print_node( node.right )
  end

  def print_mult( node )
    print_node( node.left )
    print ' * '
    print_node( node.right )
  end
  
  def print_dot( node )
    print_node( node.left )
    print ' . '
    print_node( node.right )
  end
  
  def print_vec( node )
    print '['
    node.elements.each_with_index do |elem, idx|
      print ', ' if idx > 0
      print_node( elem )
    end

    print ']'
  end

  def print_assign( node )
      print_node( node.id )
      print ' = '
      print_node( node.value )
      puts
  end

  def print_print( node )
    print 'print '
    print_node( node.value )
    puts    
  end

  def print_stat_list( node )
    node.elements.each { |e| print_node( e ) }
  end  
end
