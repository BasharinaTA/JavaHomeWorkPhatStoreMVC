"use strict";

const categories = document.querySelector(".categories");
categories.addEventListener("click", (evt) => {
    const category = evt.target.closest(".category");
    if (!category) return;
    const categoryName = category.querySelector(".category_caption").innerText;
    window.location.href=`/category/${categoryName}`;
})

document.getElementById("admin-item").addEventListener("click", () => {
    window.location.href=`/admin`;
})

