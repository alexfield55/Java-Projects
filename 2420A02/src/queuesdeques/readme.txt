/******************************************************************************
 *  Name:    Alex Field
 *  Partner Name:     Ariel Wilson
 ******************************************************************************/

Programming Assignment 2: Deques and Randomized Queues


/******************************************************************************
 *  Explain briefly how you implemented the randomized queue and deque.
 *  Which data structure did you choose (array, linked list, etc.)
 *  and why?
 *****************************************************************************/
For the deque we chose a linked list implementation because it made sense to be able
to check the front and back of the list and be able to iterate those positions using the 
node structuring

For the randomized queue we implemented an array structure. Using the provided
uniform shuffle method, it made it fairly simple to shuffle the array. Also using
the uniform random number generator made it very simple just to pick a random index
element from the array.

/******************************************************************************
 *  How much memory (in bytes) do your data types use to store n items
 *  in the worst case? Use the 64-bit memory cost model from Section
 *  1.4 of the textbook and use tilde notation to simplify your answer.
 *  Briefly justify your answers and show your work.
 *
 *  Do not include the memory for the items themselves (as this
 *  memory is allocated by the client and depends on the item type)
 *  or for any iterators, but do include the memory for the references
 *  to the items (in the underlying array or linked list).
 *****************************************************************************/

Randomized Queue:   ~  _24N____  bytes

Deque:              ~  __48N___  bytes

According to section 1.4, the overhead of any array, which is what was used in the 
randomized queue, is 24 bytes so 24N for the total memory cost.

Also according to that section, a linked list operation involves 40 bytes of overhead
although ours is doubly linked so an extra 8 bytes for an additional reference brings us 
to 48N for N operations.




/******************************************************************************
 *  Known bugs / limitations.
 *****************************************************************************/
We did not find any bugs, but that doesn't mean there arent any

/******************************************************************************
 *  Describe whatever help (if any) that you received.
 *  Don't include readings, lectures, and precepts, but do
 *  include any help from people (including course staff, lab TAs,
 *  classmates, and friends) and attribute them by name.
 *****************************************************************************/
We just worked on it together.


/******************************************************************************
 *  If you worked with a partner, assert below that you followed
 *  the protocol as described on the assignment page. Give one
 *  sentence explaining what each of you contributed.
 *****************************************************************************/
Ariel Wilson and I worked together. Ariel contributed the Deque class and I
(Alex Field) contributed the RandomizedQueue class.


/******************************************************************************
 *  Describe any serious problems you encountered.                    
 *****************************************************************************/
No serious problems


/******************************************************************************
 *  List any other comments here. Feel free to provide any feedback   
 *  on how much you learned from doing the assignment, and whether    
 *  you enjoyed doing it.                                             
 *****************************************************************************/