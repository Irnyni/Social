<template>
    <div class="formsss">
        <cab><h1>EDITAR VÍDEO</h1></cab>
        
        <v-sheet class="mx-auto" width="60%" >
            <v-form fast-fail @submit.prevent="submitForm">
                <v-text-field
                    v-model="titulo"
                    label="Título"
                ></v-text-field>
                <v-img :src="capa.value"></v-img>
                <v-text-field
                    v-model="capa"
                    label="Capa"
                ></v-text-field>
                <v-text-field
                    v-model="descricao"
                    label="Descrição"
                ></v-text-field>

                <v-file-input prepend-icon="mdi-camera"  clearable label="Envie uma imagem de capa" variant="outlined"></v-file-input>
                <v-file-input prepend-icon="mdi-video"  clearable label="Carregar video" variant="outlined"></v-file-input>

                <v-btn class="mt-12" type="submit" block>Submit</v-btn>
            </v-form>
        </v-sheet>
    </div>
</template>

<script setup>

import { ref, onMounted } from 'vue';
import { useRoute } from 'vue-router';  // Importando useRoute para pegar o id da URL
import axios from 'axios';

// Referências para os campos do formulário
const titulo = ref('');
const capa = ref('');
const descricao = ref('');
const id = ref(null);  // Armazenar o id do vídeo

// Usando useRoute para pegar o id da URL
const route = useRoute();
id.value = route.params.id;  // Pega o id da URL

// Quando o componente for montado, busque os dados do vídeo para edição
onMounted(async () => {
    try {
        const response = await axios.get(`http://localhost:8077/Videos/${id.value}`);
        const video = response.data;

        
        titulo.value = video.titulo;
        capa.value = video.capa;
        descricao.value = video.descricao;
    } catch (error) {
        console.error('Erro ao buscar os dados do vídeo:', error);
    }
});

// Função para enviar os dados do formulário
const submitForm = async () => {
    try {
        const DADOS = {
            id: id.value,
            titulo: titulo.value,
            capa: capa.value,
            descricao: descricao.value
        };

        // Requisição PUT para atualizar o vídeo
        const response = await axios.put(`http://localhost:8077/Videos/${id.value}`, DADOS, {
            headers: {
                'Content-Type': 'application/json'
            }
        });

        console.log('Dados atualizados com sucesso:', response.data);

        // Limpar os campos do formulário após sucesso
        titulo.value = '';
        capa.value = '';
        descricao.value = '';
    } catch (error) {
        console.error('Erro ao enviar dados:', error);
    }
};
</script>

<style scoped>
.mx-auto {
    margin: 80px;
    align-self: flex-start;
}

.v-input {
    margin: 30px;
    padding: 20px;
}

.mt-2 {
    width: 100px;
}
.imagem {
  position: relative; 
  background-color: #000000;
  background-size: cover;
  overflow: hidden;
}
.v-img{
  max-height: 650px;
  min-width: 100%;
  object-fit: cover;


  border-radius: 40px;
  background-size: cover;
 

}
</style>
