<template>
 <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet">
   
  <header class="header">
 
    <nav class="navbar navbar-expand-sm navbar-dark bg-dark">
  <div class="container-fluid">
    <a class="navbar-brand" href="javascript:void(0)">Dapos</a>
    <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#mynavbar">
      <span class="navbar-toggler-icon"></span>
    </button>
    <div class="collapse navbar-collapse" id="mynavbar">
      <ul class="navbar-nav me-auto">
        <li class="nav-item">
          <a class="nav-link" href="/">home</a>
        </li>
        <li class="nav-item">
          <a class="nav-link" href="/">produtos</a>
        </li>
        <li class="nav-item">
          <a class="nav-link" href="/">sobre</a>
        </li>
      </ul>
      <form class="d-flex">
        <input class="form-control me-2" type="text" placeholder="Search">
        <button class="btn btn-primary" type="button">Search</button>
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
  background:rgb(255, 255, 255);
  color: white;

  text-align: left;
  
}


</style>
