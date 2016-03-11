//create a Linked-list for integer from user input

#include <stdio.h>
#include <stdlib.h>

struct node
{
	int data;
	struct node *next;
};

struct node *headInsert(struct node *head, int input)
{
	struct node *new;
	new = malloc(sizeof(struct node));
	new->data = input;
	new->next = head;
	return new;
}

void insert(struct node *node, int input)
{
	struct node *prev = node;
	int inserted = 0;
	struct node *curr = node->next;

	while(curr != NULL)
	{
		if(input <= curr->data)
		{
			struct node *new;
			new = malloc(sizeof(struct node));
			new->data = input;
			new->next = curr;
			prev->next = new;
			inserted = 1;
			break;
		};
		prev = curr;
		curr = curr->next;	
	}
	if(!inserted)
	{
		struct node *new;
		new = malloc(sizeof(struct node));
		new->data = input;
		prev->next = new;
		new->next = NULL;
	}
}

main()
{
	struct node *head;
	struct node *move;
	int input;
	head = malloc(sizeof(struct node));

	scanf("%d", &input);
	if(head != NULL)
	{
		head->data = input;
		head->next = NULL;
	}
	scanf(" %d", &input);
	while(input >= 0)
	{
		if(input <= head->data)
		{
			head = headInsert(head, input);
		}
		else
		{
			insert(head, input);
		}
		scanf(" %d", &input);
	}

	printf("The linked list is:\n");
	move = head;
	while(move != NULL)
	{
		printf("%d-->", move->data);
		move = move->next;
	}
	printf("NULL\n");

	while(head != Null)
	{
		struct node *node;
		node = head;
		head = head->next;
		free(node);
	}
}
