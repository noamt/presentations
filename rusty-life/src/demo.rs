extern crate cursive;

use cursive::Cursive;
use cursive::views::{Dialog, TextView};

fn main() {
    let mut siv = Cursive::default();

    siv.add_layer(Dialog::around(TextView::new("Hello Rust TLV!"))
                         .title("Cursive @ Rust TLV")
                         .button("Quit", |s| s.quit()));

    siv.run();
}