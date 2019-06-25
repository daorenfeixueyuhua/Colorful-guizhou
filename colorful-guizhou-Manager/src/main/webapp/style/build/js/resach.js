function lastPage() {
    var cnt = pageForm.currentPage.value.valueOf();
    cnt = Number(cnt);
    if (cnt != 1) {
        pageForm.currentPage.value = cnt - 1;
    }
}

function nextPage() {
    var cnt = pageForm.currentPage.value.valueOf();
    cnt = Number(cnt);
    pageForm.currentPage.value = cnt + 1;
}