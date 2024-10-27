<template>

  <cab><h1>VÍDEOS</h1></cab>
      
  <div class="corpo">
   <!-- <pre>{{ items }}</pre>  Mostra o conteúdo bruto de items -->
    <!-- <h1>Lista de Itens</h1>
    <ul>
      <li v-for="item in items" :key="item.id">{{ item.titulo }}</li>
    </ul> -->

      
   <v-row>
      
    <v-col
          
          v-for="item in items"
          :key="item.id"
          
           
        >
          <v-card>
    <v-row>    <div class="intro">
    
    <v-card-text style="font-size: 35px;font-weight: bolder; border-right: 0.1px solid #000000;">
            {{ item.titulo }}
          </v-card-text>
      <div> <v-card-text style="font-size: 20px;">
            {{ item.descricao }}
          </v-card-text></div>
           
     


  </div></v-row>


    <div class="imagem">
              <v-img :src="item.capa"></v-img>
            </div>
           

<div class="dados">

  <v-card-text style="font-size: 20px;">
      <v-icon>mdi-clock</v-icon> Tempo: {{ item.duracao }} Min
    </v-card-text>
    <v-card-text style="font-size: 20px;">
      <v-icon>mdi-thumb-up</v-icon> Likes: {{ item.curtidas }}
    </v-card-text>
    <v-card-text style="font-size: 20px;">
      <v-icon>mdi-thumb-down</v-icon> Deslikes: {{ item.deslikes }}
    </v-card-text>
    <v-card-text style="font-size: 20px;">
      <v-icon>mdi-share</v-icon> Shares: {{ item.compartilhamento }}
    </v-card-text>
           
</div>
      
            
            
          </v-card>
        </v-col>
      </v-row>
  </div>
</template> 

<script>
export default {
  data() {
    return {
      items: [],
    }
  },
  async mounted() {
  try {
    const response = await fetch('http://localhost:8077/Videos');
    if (!response.ok) {
      throw new Error('Network response was not ok');
    }
    const data = await response.json();
    this.items = data;
    console.log(this.items); // Adicione este log para verificar os dados
  } catch (error) {
    console.error('Erro ao buscar itens:', error);
  }
}

}
</script>

<style scoped>
.corpo{
  display: flex;
  background-color: rgb(255, 255, 255);
}
body {
    font-family: Arial, sans-serif;
    align-items: center;
    background-color: #f0f0f0;
    color: #333;

}
   .v-card{width:1100px;

  text-align: center;
  margin-bottom: 70px;
  margin-left: 250px;
  border-radius: 40px;
 
}

v-col{ align-items: center;}
.v-row{ display: flex;align-items: center;;flex-direction: row;}
.v-img{
  max-height: 650px;
  min-width: 100%;
  object-fit: cover;


  border-radius: 40px;
  background-size: cover;
 

}
cab{ text-align: center;
    font-family: 'Segoe UI', Tahoma, Geneva, Verdana, sans-serif;
}

h1{

  font-size: 120px;
  font-family:monospace;
}
.imagem{
background-color: #000000;
  background-size: cover; /* Preencher o card */
  object-fit: cover;
  

 
}
.dados{

  display: flex;
  align-items: center;
  font-family: 'Gill Sans', 'Gill Sans MT', Calibri, 'Trebuchet MS', sans-serif;
  background-color: #ffffffa9;
  font-weight: bolder;
  color: #420000;
  
}
.intro{
    display: flex;
    justify-content: space-between;
    text-align: center;
    padding: 30px
    

}

</style>
