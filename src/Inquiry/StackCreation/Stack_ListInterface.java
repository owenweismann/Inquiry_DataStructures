package Inquiry.StackCreation;

/**
 * ListInterface is a light version
 * of the Java API List interface
 *
 * - it uses Object rather than template class syntax
 * - represents a subset of methods
 *
 * @author J. Smith
 * @version September 2021
 */
public interface Stack_ListInterface
{
    public boolean add (Object element);
    public void add (int index, Object element);
    public void clear ();
    public boolean contains (Object element);
    public Object get (int index);
    public int indexOf (Object element);
    public int lastIndexOf (Object element);
    public boolean remove (Object element);
    public Object remove (int index);
    public Object set (int index, Object element);
    public int size ();

}
