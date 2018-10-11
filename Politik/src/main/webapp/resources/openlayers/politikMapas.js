var mapa;
var format = 'image/png';
var serverWMS = 'https://' + document.location.hostname + '/politik/OL4JSFProxy/wms';

function iniciarMapa(bounds, estilos, capas, cqlFilter, panelMapa){
	
	var capaOSM = new ol.layer.Tile({
		source: new ol.source.OSM()
	});
	
	var capaBase = new ol.layer.Tile({
		opacity: 0.5,
		source: new ol.source.TileWMS({
				ratio: 1,
				url: serverWMS,
				params: {
					'FORMAT': format,
					'VERSION': '1.1.1',  
					STYLES: estilos,
					LAYERS: capas,
					'CQL_FILTER': cqlFilter,
				}
		})
	});
	
	var proyeccion = new ol.proj.Projection({
		code: 'EPSG:4326',
		units: 'degrees',
		axisOrientation: 'neu'
	});
	
	var vista = new ol.View({
		projection: proyeccion
	});
	
	mapa = new ol.Map({
		layers: [
		    capaOSM,
			capaBase
		],
		view: vista,
		target: panelMapa
	});
	
	mapa.getView().fit(bounds, mapa.getSize());
}

function iniciarMapaNacional(panelMapa){
	
	var capaOSM = new ol.layer.Tile({
		source: new ol.source.OSM()
	});
	
	var proyeccion = new ol.proj.Projection({
		code: 'EPSG:4326',
		units: 'degrees',
		axisOrientation: 'neu'
	});
	
	var vista = new ol.View({
		projection: proyeccion
	});
	
	mapa = new ol.Map({
		layers: [
		    capaOSM
		],
		view: vista,
		target: panelMapa
		
	});
	
	mapa.getView().fit([-118.454994376215, 14.5330668762905, -86.712489103835, 32.7220212408026], mapa.getSize());
}

function actualizarMapa(bounds){
	mapa.getView().fit(bounds, mapa.getSize());
}

function actualizarCapa(itemCapa, cqlFilter){
	var parametros = {'CQL_FILTER': cqlFilter};
	mapa.getLayers().item(itemCapa).getSource().updateParams(parametros);
}

function agregarCapa(capa, estilos, cqlFilter){
	var capaNueva = new ol.layer.Tile({
		opacity: 0.5,
		source: new ol.source.TileWMS({
				ratio: 1,
				url: serverWMS,
				params: {
					'FORMAT': format,
					'VERSION': '1.1.1',  
					STYLES: estilos,
					LAYERS: capa,
					'CQL_FILTER': cqlFilter,
				}
		})
	});
	
	mapa.addLayer(capaNueva);
}

function quitarCapa(itemCapa){
	mapa.removeLayer(mapa.getLayers().item(itemCapa));
}
