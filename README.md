# Count The Islands

#### Assignment:
Generate a 2D matrix with random 0's and 1's where 0 presents water and 1 presents land. Hence the title "count the islands". First trying with small tabels that can actually be checked if they are correct. Then generating bigger tables.

Here are some steps how i worked on the assignment:
1. Generated 2D matrix (only zeros);
2. Assigned random 0 and 1 numbers to matrix;
3. Made the user input to have different size of matrix;
4. Made checkMatrix() function, that counted every single 1;
5. Made checkNeighbour() function, that checked 4 neighbours (left, up, down, right) and kept in mind if the position has been visited or not;
6. Had to make a new function that checks if the neighbour position has been visited already or not – this helped to group the „islands“

The algorithm uses is a **modified DFS**. Works fine even with 10k x 10k table, which takes some time to generate. 100k gave me some kind of an error that said "Java heap space" which i guess means there is not enought memory/space to generate the table? The code has quite a lot of comments to explain what each part does.

I will be improving the code in the near future to try multithreading where each thread starts from a different corner and in the end the threads will still give a correct number of islands, saving you memory. Possibly it will be under a different repo.
