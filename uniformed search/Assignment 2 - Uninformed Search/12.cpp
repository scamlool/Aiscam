#include <stdio.h>
#include <stdlib.h>
#include <stdbool.h>
#define MAX_NODES 7

struct Queue
{
    int front, rear;
    int items[MAX_NODES];
};
struct Queue *createQueue()
{
    struct Queue *queue = (struct Queue *)malloc(sizeof(struct Queue));
    queue->front = -1;
    queue->rear = -1;
    return queue;
}
bool isEmpty(struct Queue *queue)
{
    return queue->rear == -1;
}
void enqueue(struct Queue *queue, int item)
{
    if (queue->rear == MAX_NODES - 1)
    {
        return;
    }
    if (queue->front == -1)
    {
        queue->front = 0;
    }
    queue->rear++;
    queue->items[queue->rear] = item;
}
int dequeue(struct Queue *queue)
{
    if (isEmpty(queue))
    {
        return -1;
    }
    int item = queue->items[queue->front];
    queue->front++;
    if (queue->front > queue->rear)
    {
        queue->front = queue->rear = -1;
    }
    return item;
}
void bfs(int graph[MAX_NODES][MAX_NODES], int nodes, int startNode)
{
    struct Queue *queue = createQueue();
    int visited[MAX_NODES] = {0};
    printf("Breadth-First Traversal: ");
    visited[startNode] = 1;
    enqueue(queue, startNode);
    while (!isEmpty(queue))
    {
        int currentNode = dequeue(queue);
        printf("%d ", currentNode);

        for (int i = 0; i < nodes; i++)
        {
            if (graph[currentNode][i] == 1 && !visited[i])
            {
                visited[i] = 1;
                enqueue(queue, i);
            }
        }
    }
    printf("\n");
}
struct Stack
{
    int top;
    int items[MAX_NODES];
};

struct Stack *createStack()
{
    struct Stack *stack = (struct Stack *)malloc(sizeof(struct Stack));
    stack->top = -1;
    return stack;
}

bool isEmptyS(struct Stack *stack)
{
    return stack->top == -1;
}

void push(struct Stack *stack, int item)
{
    if (stack->top == MAX_NODES - 1)
        return;
    stack->items[++stack->top] = item;
}

int pop(struct Stack *stack)
{
    if (isEmptyS(stack))
        return -1;
    return stack->items[stack->top--];
}
void dfs(int graph[MAX_NODES][MAX_NODES], int numNodes, int startNode)
{
    struct Stack *stack = createStack();
    int visited[MAX_NODES] = {0};

    printf("Depth-First Traversal: ");
    push(stack, startNode);
    visited[startNode] = 1;

    while (!isEmptyS(stack))
    {
        int currentNode = pop(stack);

        printf("%d ", currentNode);

        for (int i = 0; i < numNodes; i++)
        {
            if (graph[currentNode][i] == 1 && !visited[i])
            {
                push(stack, i);
                visited[i] = 1;
            }
        }
    }

    printf("\n");
}
int main()
{
    int nodes = 7;
    int choice = 0;
    int graph[MAX_NODES][MAX_NODES] = {
        {0, 1, 1, 1, 0, 0, 0},
        {1, 0, 1, 0, 0, 0, 0},
        {1, 1, 0, 1, 1, 0, 0},
        {1, 0, 1, 0, 1, 0, 0},
        {0, 0, 1, 1, 0, 1, 1},
        {0, 0, 0, 0, 1, 0, 0},
        {0, 0, 0, 0, 1, 0, 0}};

    int startNode = 0;
    printf("\n Select Traversal \n 1.BFS \n 2.DFS \n 3.both\n");
    scanf("%d", &choice);
    if (choice == 1)
    {

        bfs(graph, nodes, startNode);
    }
    else if (choice == 2)
    {

        dfs(graph, nodes, startNode);
    }
    else if (choice == 3)
    {

        bfs(graph, nodes, startNode);
        dfs(graph, nodes, startNode);
    }
    else
    {
        printf("\n Enter valid choice ");
    }
    return 0;
}
