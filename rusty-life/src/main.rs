extern crate rand;
extern crate cursive;

use std::env;
use cursive::{Cursive};
use std::{thread, time};
use rand::Rng;
use cursive::traits::*;
use cursive::views::{Dialog, TextView};

fn main() {
    let args: Vec<String> = env::args().collect();

    let size = &args[1];
    let matrix_size = size.parse().unwrap();

    let mode = &args[2];
    if mode == "ugly" {
        ugly_life(matrix_size);
    } else if mode == "pretty" {
        pretty_life(matrix_size);
    }
}

fn ugly_life(matrix_size: i32) {
    let mut iterations = 0;
    let mut life: Vec<Vec<bool>> = Vec::new();
    loop {
        if iterations == 0 {
            life = randomize_life(matrix_size);
        } else {
            life = evolve(&life);
        }
        iterations+=1;
        let printed_life = print_life(&life);
        println!("#\n# Iteration: {}\n#", iterations);
        println!("{}", printed_life);
        thread::sleep(time::Duration::from_millis(3000));
    }
}

fn pretty_life(matrix_size: i32) {
    let mut siv = Cursive::default();
    siv.set_fps(20);

    let cb_sink = siv.cb_sink().clone();

    thread::spawn(move || {
        let mut iterations = 0;
        let mut life: Vec<Vec<bool>> = Vec::new();
        loop {
            if iterations == 0 {
                life = randomize_life(matrix_size);
            } else {
                life = evolve(&life);
            }
            iterations+=1;
            let printed_life = print_life(&life);
            let new_title = format!("Rusty Life: {}", iterations);
            cb_sink.send(Box::new(|s: &mut Cursive| {
                s.call_on_id("text", |text: &mut TextView| {
                    text.set_content(printed_life);
                });
                s.call_on_id("dialog", |dialog: &mut Dialog| {
                    dialog.set_title(new_title);
                });
            }));
            thread::sleep(time::Duration::from_millis(3000));
        }
    });

    siv.add_layer(
        Dialog::new()
            .title("Rusty Life")
            .padding((1, 1, 1, 0))
            .content(TextView::new("").with_id("text"))
            .with_id("dialog")
    );

    siv.run();
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

fn print_life(matrix: &Vec<Vec<bool>>) -> std::string::String {
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

    return printable_life;
}