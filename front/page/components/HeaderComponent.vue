<template>
 <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet">
   
  <header class="header">
 
    <nav class="navbar navbar-expand-sm navbar-dark bg-black">
  <div class="container-fluid">
    <a class="navbar-brand" href="javascript:void(0)">VIDEOS</a>
    <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#mynavbar">
      <span class="navbar-toggler-icon"></span>
    </button>
    <div class="collapse navbar-collapse" id="mynavbar">
      <ul class="navbar-nav me-auto">
        <li class="nav-item">
          <a class="nav-link" href="/">Home</a>
        </li>
        <li class="nav-item">
          <a class="nav-link" href="/videos">Vídeos</a>
        </li>
        <li class="nav-item">
          <a class="nav-link" href="/criarVideo">Criar</a>
        </li>
      </ul>
      <form class="d-flex">
        <input class="form-control me-2" type="text" placeholder="O que deseja ver agora?">
        <button class="btn btn-primary" type="button">Buscar video</button>
      </form>
    </div>
  </div>
</nav>
  </header>
</template>

<script>
export default {
  name: 'HeaderComponent'
}

</script>

<style scoped>
.header {

  position: fixed; /* Fixa o cabeçalho no topo */
    top: 0; /* Alinha ao topo da página */
    left: 0;
    width: 100%; /* Largura total da página */
    background-color: white; /* Cor de fundo do cabeçalho */
    box-shadow: 0 2px 5px rgba(0, 0, 0, 0.1); /* Sombra opcional */
    z-index: 1000; /* Certifica-se de que o cabeçalho fica acima do conteúdo */
     text-align: left;
     margin-bottom: 20px;

  
}


</style>
