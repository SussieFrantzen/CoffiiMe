
fetch('/color')
    .then(res => res.json())
    .then(colors => {
        document.body.style.backgroundColor = colors[0];
    });