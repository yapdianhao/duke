# User Guide

## Features 
* Create tasks
* Show tasks
* Delete tasks
* Set tasks as done
* Find tasks
* Save tasks
* Prevents duplicate tasks
* Exits Duke

### Feature 1 : Create tasks
Duke is a personal chatbot assistant to help you manage your tasks.
Tasks can be further categorized into deadlines and events, 
each with a specific format. 

###Feature 2: Show tasks
To ease the user in deciding what to do, duke is able to show a series
of tasks created chronologically to the user. Each task is shown with its
description, the status of completion, and the time to complete if the task
is a deadline or an event.

### Feature 3: Delete tasks
Users are able to delete certain tasks after completion or the task
is no longer needed.

### Feature 4: Set tasks as done
After a user has finished a task, he will receive a congratulate message
from the duke, and the duke will update the task's status accordingly.

### Feature 5: Find tasks
Users may have a number of tasks which is relevant to a subject, and may 
have confusion of which task is needed for completion first. The duke is
able to filter tasks, and show relevant task based on the user input.

### Feature 6: Save tasks
Duke is also memorable. If the user has unfinished task, the duke will
record it and remind the user again the next time duke is called.

### Feature 7: Prevents duplicate task
To avoid having the same tasks in the list, duke is equipped with a 
detector such that he will warn the user if the user attempts to create
the exact same tas.

### Feature 8: Exits Duke
The duke will sent a goodbye message should the user requests to turn it
off.

## Usage

### `list` - Shows a list of current pending tasks.
 
The duke not only shows newly created tasks by the user in the current
session, but also loads previously uncompleted tasks.

Example of usage: 

`list`

Expected outcome:

<img height="300" src="./images/list.jpg" width="450">



