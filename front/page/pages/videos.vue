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
  <div class="overlay"></div>
  <v-btn class="mt-12" @click="deleteVideo(item.id)" block color="red">Excluir</v-btn>


 
</div>
<v-btn :href="'/editarVideo' + item.id" >Editar</v-btn>



 

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
  };
  
},
 methods:{
      async deleteVideo(id) {
          try {
            // Solicitação DELETE para excluir o vídeo
            const response = await fetch(`http://localhost:8077/Videos/${id}`, {
              method: 'DELETE',
            });

            if (response.ok) {
              // Remover o item localmente após a exclusão
              this.items = this.items.filter(item => item.id !== id);
              console.log(`Vídeo com ID ${id} excluído com sucesso.`);
            } else {
              console.error('Erro ao excluir o vídeo:', response.statusText);
            }
          } catch (error) {
            console.error('Erro ao excluir o vídeo:', error);
          }},
          async editVideo(id) {
      try {
        const response = await fetch(`http://localhost:8077/Videos/${id}`, {
          method: 'PUT', // Para edição, o método deve ser PUT
        });

        if (response.ok) {
          // Após editar, remova o item da lista localmente
          this.items = this.items.filter(item => item.id !== id);
          console.log(`Vídeo com ID ${id} editado com sucesso.`);
        } else {
          console.error('Erro ao editar o vídeo:', response.statusText);
        }
      } catch (error) {
        console.error('Erro ao editar o vídeo:', error);
      }
    }
  }
};
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
.imagem {
  position: relative; 
  background-color: #000000;
  background-size: cover;
  overflow: hidden;
}

.overlay {
  position: absolute;
  top: 0;
  left: 0;
  right: 0;
  bottom: 0;
  background-color: rgba(0, 0, 0, 0.5); 
  opacity: 0; 
  transition: opacity 0.4s; 
}

.imagem:hover .overlay {
  opacity: 6; 
}


</style>
