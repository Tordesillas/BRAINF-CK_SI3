#include <stdio.h>
#include <stdlib.h>
#include <string.h>

#define SIZE_MEMORY 300/*00*/
#define OFFSET 128

#define INCR 	memory[i]++;
#define DECR 	memory[i]--;
#define BACK 	if (memory[i] != 0) { j = pop_item(&s); p = getElement(l, j); }
#define IN 		getchar();
#define JUMP 	push_item(&s, j);
#define OUT 	printf("%c\n", memory[i]);
#define RIGHT 	i++;
#define LEFT 	i--;


//Pile
struct elt {
  int value;
  struct elt *next;
};

typedef struct elt elt;
typedef elt *Stack;

void push_item(Stack *stack, int n) {
  elt *new = malloc(sizeof(elt)); // create a new element

  if (!new) {
    fprintf(stderr, "allocation failed\n");
    exit(1);
  }
  new->value  = n;
  new->next   = *stack;
  *stack      = new;            // set the given stack to its new value
}

int pop_item(Stack *stack) {
  elt *old = *stack;

  if (old) {
    int old_value = old->value;

    *stack = (*stack)->next;
    free(old);
    return old_value;
  }
  fprintf(stderr, "pop on an empty stack!!!\n");
  exit(1);
}


//Liste
struct element {
  char instr;
  struct element *next;
};

typedef struct element Element;
typedef Element *List;

List append_element(List lst, char s) {
  Element *tmp = malloc(sizeof(Element));
  tmp->instr = s;
  tmp->next  = NULL;

  if (lst == NULL)
    return tmp;

  Element *p;
  for (p=lst; p->next; p = p->next) {}

  p->next = tmp;

  return lst;
}

Element *getElement(List lst, int count) {
	Element *p;
	p=lst;
	for (int k = 0; k < count; k++) {
		p = p->next;
	}
	return p;
}


int main() {
	char memory[SIZE_MEMORY] = {};	 //mémoire
	int i = 0;						 //pointeur en mémoire
	int j = 0;	 					 //pointeur d'instruction
	Stack s = NULL;					 //pile de jump
	List l = NULL;					 //liste d'instructions

	l = append_element(l, '+');
	j++;

	l = append_element(l, '+');
	j++;

	l = append_element(l, '[');
	j++;

	l = append_element(l, '>');
	j++;

	l = append_element(l, '+');
	j++;

	l = append_element(l, '+');
	j++;

	l = append_element(l, '<');
	j++;

	l = append_element(l, '-');
	j++;

	l = append_element(l, ']');
	j++;

	int nb = j;
	Element *p = l;
	for (j = 0; j < nb; j++) {
		printf("%d\n", j);
		switch (p-> instr) {
			case '+':
				INCR
				break;
			case '-':
				DECR
				break;
			case ',':
				IN
				break;
			case '.':
				OUT
				break;
			case '<':
				LEFT
				break;
			case '>':
				RIGHT
				break;
			case '[':
				JUMP
				break;
			case ']':
				BACK
				break;
		}
		p = p->next;
    }

	//dump
	for (i = 0; i < SIZE_MEMORY; i++) {
		if (memory[i] != 0) {
			printf("C%d: %d\n", i, memory[i]);
		}
	}
	return 0;
}
