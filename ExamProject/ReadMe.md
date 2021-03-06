### Bounded Buffer Implementation using with and without design pattern

All requirements about Bounding Buffer as follows:

* The buffer shall have a limited capacity.
* Items in the buffer shall be accessed via get and put methods.
* The system shall allow one writer to access the buffer at a certain time.
* The system shall allow more than one reader to access the buffer at the same time.
* When a writer is currently accessing the buffer, all read requests shall be queued in a FIFO queue for readers, and all write requests shall be queued in a FIFO queue for writers.
* When one or more readers are accessing the buffer concurrently, all write requests shall be queued in a FIFO queue for writers.
* When the buffer is empty, and a get method is initiated, the system shall generate an error “Buffer is Empty”.
* When the buffer reaches it maximum capacity (full), and a put method is initiated, the system shall generate an error “Buffer is Full”.
