Output of resourceImpl.AsyncResourceImpl:
asyncGet Thread # 13 is doing this task task30
Returning: Thread # 13 is doing this task task30
run Thread # 14 is doing this task
asyncGet Thread # 13 is doing this task task31
Returning: Thread # 13 is doing this task task31
run Thread # 16 is doing this task
Expensive operation done by thread 14
asyncGet Thread # 13 is doing this task task33
Returning: Thread # 13 is doing this task task33
run Thread # 17 is doing this task
Expensive operation done by thread 16
Expensive operation done by thread 17



@ManagedAsync is used for making a jersey resource asynchronous. It means that complete resource execution is done in another thread, not in the main thread in which request is received.

There are 2 ways for making asynchronous jersey resource -

1) Using @Suspended on AsyncResponse asyncResponse - But in this case, you have to create your own thread in code and execute expensive task in that thread.

2) Using @ManagedAsync - In this case, there is no need to create new thread manually, jersey creates thread and execute resource method in that thread.

More information can be found at Async Rest


Executor: 


