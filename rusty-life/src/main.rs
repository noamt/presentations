extern crate rand;

use std::{thread, time};
use rand::Rng;

fn main() {
    println!("Rusty Life!");
    let matrix_size = 20;
    println!("Matrix size is {}", matrix_size);

    let mut life = randomize_life(matrix_size);

    loop {
        print_life(&life);
        thread::sleep(time::Duration::from_millis(3000));
        life = evolve(&life);
    }
}

fn randomize_life(matrix_size: i32) -> Vec<Vec<bool>> {
    let mut randomized_matrix: Vec<Vec<bool>> = Vec::new();
    let mut thread_rng = rand::thread_rng();

    for _row in 0..matrix_size {
        let mut randomized_row: Vec<bool> = Vec::new();

        for _column in 0..matrix_size {
            let random_value = thread_rng.gen_range(0, 2);
            let value = if random_value == 0 {
                false
            } else {
                true
            };
            randomized_row.push(value);
        }

        randomized_matrix.push(randomized_row);
    }

    return randomized_matrix;
}

fn evolve(matrix: &Vec<Vec<bool>>) -> Vec<Vec<bool>> {
    let mut evolved_matrix: Vec<Vec<bool>> = Vec::new();

    for row in 0..(matrix.len() as i32) {
        let mut new_row: Vec<bool> = Vec::new();

        for column in 0..(matrix.len() as i32) {
            let cell_state = is_cell_active(matrix, row, column);
            new_row.push(cell_state);
        }

        evolved_matrix.push(new_row);
    }

    return evolved_matrix;
}

fn is_cell_active(matrix: &Vec<Vec<bool>>, row: i32, column: i32) -> bool {
    let mut active_neighbours = 0;
    for neighbour_row in -1..2 {

        for neighbour_column in -1..2 {

            if (row + neighbour_row < 0) || (column + neighbour_column < 0) || (row + neighbour_row >= (matrix.len() as i32)) || (column + neighbour_column >= (matrix.len() as i32)) || (neighbour_row == 0 && neighbour_column == 0) {
                continue;
            }
            let row_vector: Vec<bool> = matrix.get((row + neighbour_row) as usize).unwrap().to_vec();
            let value_at: Option<&bool> = row_vector.get((column + neighbour_column) as usize);
            if *(value_at.unwrap()) {
                active_neighbours = active_neighbours + 1;
            }
        }
    }
    if active_neighbours < 2 || active_neighbours > 3 {
        return false;
    }
    return true;
}

fn print_life(matrix: &Vec<Vec<bool>>) {
    let mut printable_life: std::string::String = "".to_string();
    for row in matrix {
        for column in row {
            let value =  if *column {
                "[x]"
            } else {
                "[ ]"
            };
            printable_life = printable_life.to_owned() + value;
        }
        printable_life = printable_life.to_owned() + "\n";
    }

    println!("{}", printable_life);
}