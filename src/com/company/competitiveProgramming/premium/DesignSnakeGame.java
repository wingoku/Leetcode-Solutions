package com.company.competitiveProgramming.premium;
class SnakeGame {

    /** Initialize your data structure here.
     @param width - screen width
     @param height - screen height
     @param food - A list of food positions
     E.g food = [[1,1], [1,0]] means the first food is positioned at [1,1], the second is at [1,0]. */

    private int[][] food;
    private LinkedList<Pair<Integer, Integer>> snake;
    private int width;
    private int height;
    private int foodIndex;
    private Set<Pair<Integer, Integer>> body;

    public SnakeGame(int width, int height, int[][] food) {
        this.width = width;
        this.height = height;
        this.food = food;

        body = new HashSet<>();

        snake= new LinkedList<>();
        snake.addFirst(new Pair<>(0, 0));
        body.add(new Pair<>(0, 0));
    }

    /** Moves the snake.
     @param direction - 'U' = Up, 'L' = Left, 'R' = Right, 'D' = Down
     @return The game's score after the move. Return -1 if game over.
     Game over when snake crosses the screen boundary or bites its body. */
    public int move(String direction) {

        int i = snake.peek().getKey();
        int j = snake.peek().getValue();

        switch(direction) {
            case "U":
                i = i-1;
                break;

            case "D":
                i = i+1;
                break;

            case "L":
                j = j-1;
                break;

            case "R":
                j = j+1;
                break;
        }

        // System.out.println("snakeHead: "+ i + " "+ j + " body: "+ body.toString() + " contains: "+ body.contains(newHead));
        if(isCollidingWithBoundaries(i, j))
            return -1;

        boolean foodEaten = false;
        if(foodIndex < food.length){

            //we're keeping index of food array cuz the question mentiond that food appears in the grid in the order its given in the food array
            //therefore once a food position has been reached by the snake head, we just increment the index of food array
            int[] nextFoodLocation = food[foodIndex];
            if(nextFoodLocation[0] == i && nextFoodLocation[1] == j) {
                foodEaten = true;
                foodIndex++;
            }
        }

        if(!foodEaten) {
            Pair<Integer,Integer> tailToRemove = snake.removeLast();
            body.remove(tailToRemove);
        }

        Pair<Integer, Integer> newHead = new Pair<>(i, j);

        //checking if the snake bititself after we've removed the tail of the snake (we remove tail only if the snake hasn't eaten food cuz in the game when the snake eats food, it grows and the tail remains at the same place. If it has eaten than we remove the tail to move the snake forward)
        if(isSnakeBittingItself(newHead))
            return -1;

        snake.addFirst(newHead);
        body.add(newHead);

        return snake.size()-1;
    }

    private boolean isCollidingWithBoundaries(int i, int j) {
        if(i < 0 || i >= height || j < 0 || j >= width)
            return true;

        return false;
    }

    private boolean isSnakeBittingItself(Pair<Integer,Integer> node) {
        return body.contains(node);
    }

}

/**
 * Your SnakeGame object will be instantiated and called as such:
 * SnakeGame obj = new SnakeGame(width, height, food);
 * int param_1 = obj.move(direction);
 */