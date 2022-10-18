var cvs = document.getElementById("canvas");
var ctx = cvs.getContext("2d");

//Carregando as imagens
var bird = new Image();
var bg = new Image();
var fg = new Image();
var pipeS = new Image();
var pipeI = new Image();

bird.src = "img/bird.png";
bg.src = "img/bg.png";
fg.src = "img/fg.png";
pipeS.src = "img/pipeNorth.png";
pipeI.src = "img/pipeSouth.png";

//Variáveis de Jogabilidade
var gap = 85; //Tamanho espaço entre tubos
var constante;
var bX = 10;
var bY = 150;
var gravidade = 1.5; //Velocidade queda
var score = 0;

//Variáveis de Audios
var fly = new Audio();
var scoreAudio = new Audio();

fly.src = "sounds/fly.mp3";
scoreAudio.src = "sounds/score.mp3";

//Evento ao Pressionar a tecla
document.addEventListener("keydown", moveUp);

//Função chamada pelo evento acima(moveUp)
function moveUp() {
    bY -= 30; //Pulo
    fly.play();
}

//Cordenadas das Tubulaçãoes
var pipe = [];
pipe[0] = { x: cvs.width, y: 0 };

//Jogabilidade
function draw() {
    ctx.drawImage(bg, 0, 0);
    for (var i = 0; i < pipe.length; i++) {
        constante = pipeS.height + gap;
        ctx.drawImage(pipeS, pipe[i].x, pipe[i].y);
        ctx.drawImage(pipeI, pipe[i].x, pipe[i].y + constante);
        pipe[i].x--; //Pesquisar esse conceito

        if (pipe[i].x == 10) { //tubos mais longe
            pipe.push({ x: cvs.width, y: Math.floor(Math.random() * pipeS.height) - pipeS.height });
        }
        //Verficando a colisão
        if (bX + bird.width >= pipe[i].x && bX <= pipe[i].x + pipeS.width && (bY <= pipe[i].y + pipeS.height ||
                bY + bird.height >= pipe[i].y + constante) || bY + bird.height >= cvs.height - fg.height) {
            location.reload(); //Carrega pagina
        }
        if (pipe[i].x == 5) {
            score++;
            scoreAudio.play();
        }
    }
    ctx.drawImage(fg, 0, cvs.height - fg.height);
    ctx.drawImage(bird, bX, bY);
    bY += gravidade;

    ctx.fillStyle = "#000";
    ctx.font = "20px Verdana";
    ctx.fillText("Score: " + score, 10, cvs.height - 20);

    requestAnimationFrame(draw);
}

draw();