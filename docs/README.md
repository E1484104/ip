# Kitten User Guide

Kitten is a professional, lightweight **Command Line Interface (CLI)** task manager designed for 
students and developers who prefer typing over clicking. 
It helps you track deadlines, events, and daily to-dos with a friendly, supportive personality.

## Quick Start

1. Ensure you have **Java 17** or above installed on your computer.
2. Download the latest `Kitten.jar` from our *Releases*.
3. Open your terminal, navigate to the folder containing the file, and run:
   `java -jar Kitten.jar`
4. When the welcome message appears, type your first command!
5. Your task list will be stored in `./data/KittenList.txt`, it will be automatically
   loaded when you start the program.

## Core Features

### 1. Adding a Todo Task: `todo`
Adds a basic task without any specific time constraint.
* **Format:** `todo <description>`
* **Outcome:** Adds a Todo task marked with `[T]`.
* **Example:** `todo finish programming assignment`

### 2. Adding a Deadline Task: `deadline`
Adds a task that needs to be completed by a specific date or time.
* **Format:** `deadline <description> /by <time>`
* **Outcome:** Adds a Deadline task marked with `[D]`.
* **Example:** `deadline submit lab report /by Monday 2359`

### 3. Adding an Event Task: `event`
Adds a task that occurs during a specific time frame with a start and end time.
* **Format:** `event <description> /from <start> /to <end>`
* **Outcome:** Adds an Event task marked with `[E]`.
* **Example:** `event project meeting /from 2pm /to 4pm`

### 4. Listing all Tasks: `list`
Displays every task currently stored in the system, showing its index, type, status, and description.
* **Format:** `list`
* **Outcome:** Tasks currently in the list will be displayed as `index. [type][status] task`

### 5. Marking a Task as Done: `mark`
Changes the status of a specific task to "Completed".
* **Format:** `mark <index>`
* **Outcome:** The task status icon changes from `[ ]` to `[X]`.
* **Example:** `mark 1`

### 6. Unmarking a Task: `unmark`
Reverts a completed task back to an incomplete status.
* **Format:** `unmark <index>`
* **Outcome:** The task status icon changes from `[X]` back to `[ ]`.
* **Example:** `unmark 1`

### 7. Deleting a Task: `delete`
Permanently removes a task from the list using its numerical index.
* **Format:** `delete <index>`
* **Outcome:** The task is removed and the total task count is updated.
* **Example:** `delete 2`

### 8. Finding Tasks by Keyword: `find`
Searches for all tasks that contain a specific keyword or phrase in their description.
* **Format:** `find <keyword>`
* **Outcome:** Displays a list of all matching tasks (case-insensitive) and their original indices.
* **Example:** `find book`

### 9. Exiting the Program: `bye`
Safely closes the application and ensures all task data is saved.
* **Format:** `bye`
* **Outcome:** Displays a farewell message and terminates the session.
* **Example:** `bye`

---

## Error Handling

Kitten is designed to guide you when things go wrong. If an error occurs, you will see a specific error code followed by a "Try:" suggestion.

| Error Code | Meaning                                                    | How to Fix                                                                        |
| :--- |:-----------------------------------------------------------|:----------------------------------------------------------------------------------|
| **[InvalidType]** | The command keyword is not recognized.                     | Check for typos and use valid keywords like `todo`, `deadline`, etc.              |
| **[LackOfLabel]** | A required label is missing.                               | Ensure you include the correct label for `deadline` or `event` tasks.             |
| **[ContentIsEmpty]** | You provide a command but forget the description or index. | Add the missing text or number after the command keyword.                         |
| **[InvalidIndex]** | The task number you provide does not exist in the list.    | Use `list` to check the current task numbers and try again.                       |
| **[NonNumericalIndex]** | You entered text where a numerical index is expected.      | Replace the text with a valid numerical index.                                    |
| **[IOException]** | There is an issue accessing the data file.                  | Ensure the `./data/` folder is not set to read-only or being used by another app. |

### Example of an Error Feedback:
If you type `deadline homework` (missing the `/by` label), Kitten will respond with: